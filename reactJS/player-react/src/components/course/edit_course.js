import React from 'react';
import { Modal } from 'react-bootstrap';
import {Dialog, Form, Input, Button} from 'element-react'
import 'element-theme-default'

const EditCourseDialog = ({ formData, onFormDataChange, show, onHide }) => {
  console.log('EditCourseDialog render ...');

  const { title, url } = formData;

  return (
    <div>
      <Dialog
        title="Video update"
        visible={show}
        onCancel={() => { onHide()}}
      >
        <Dialog.Body>
          <Form >
            <Form.Item label="Title" labelWidth="120">
              <Input value={title}></Input>
            </Form.Item>
            <Form.Item label="URL" labelWidth="120">
              <Input value={url}></Input>
            </Form.Item>
          </Form>
        </Dialog.Body>

        <Dialog.Footer className="dialog-footer">
          <Button onClick={() => { onHide() }}>取 消</Button>
          <Button type="primary" onClick={ () => { onHide('save') } }>确 定</Button>
        </Dialog.Footer>
      </Dialog>
    </div>
  )
};

export default EditCourseDialog;
